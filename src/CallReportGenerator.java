import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CallReportGenerator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java CallReportGenerator <input_file_path>");
            return;
        }

        String inputFilePath = args[0];
        List<CallDetails> callDetailsList = new ArrayList<>();

        // Read the file and parse call details
        try (Stream<String> lines = Files.lines(Paths.get(inputFilePath))) {
            lines.forEach(line -> callDetailsList.add(new CallDetails(line)));
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Generate report
        Map<String, Integer> accountCostMap = new HashMap<>();
        Map<Character, Integer> callTypeCostMap = new HashMap<>();
        Map<String, Integer> dayCostMap = new HashMap<>();

        for (CallDetails call : callDetailsList) {
            // Aggregate cost by account number
            accountCostMap.put(call.getAccountNumber(),
                    accountCostMap.getOrDefault(call.getAccountNumber(), 0) + call.getCallCost());

            // Aggregate cost by call type
            callTypeCostMap.put(call.getCallType(),
                    callTypeCostMap.getOrDefault(call.getCallType(), 0) + call.getCallCost());

            // Aggregate cost by day
            String callDay = call.getStartTime().substring(0, 8);
            dayCostMap.put(callDay, dayCostMap.getOrDefault(callDay, 0) + call.getCallCost());
        }

        // Write the report
        String reportFilePath = inputFilePath.replace(".TXT", "_REPORT.TXT");
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(reportFilePath))) {
            writer.write("Report Generated:\n\n");

            writer.write("Total Cost by Account:\n");
            for (Map.Entry<String, Integer> entry : accountCostMap.entrySet()) {
                writer.write(String.format("Account: %s, Total Cost: %d\n", entry.getKey(), entry.getValue()));
            }

            writer.write("\nTotal Cost by Call Type:\n");
            for (Map.Entry<Character, Integer> entry : callTypeCostMap.entrySet()) {
                writer.write(String.format("Call Type: %s, Total Cost: %d\n", entry.getKey(), entry.getValue()));
            }

            writer.write("\nTotal Cost by Day:\n");
            for (Map.Entry<String, Integer> entry : dayCostMap.entrySet()) {
                writer.write(String.format("Day: %s, Total Cost: %d\n", entry.getKey(), entry.getValue()));
            }

            System.out.println("Report generated successfully: " + reportFilePath);
        } catch (IOException e) {
            System.err.println("Error writing the report: " + e.getMessage());
        }
    }
}
