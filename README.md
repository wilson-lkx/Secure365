# Call Report Generator

## Overview

The `CallReportGenerator` program parses a fixed-width text file containing call details and generates a report summarizing:

1. Total cost of calls per account number.
2. Total cost of calls per call type.
3. Total cost of calls per day.

## Input File Format

The input file is an ASCII text file with the following format:

- **ACCNUM** (10 characters): Account number of the customer.
- **A\_NUM** (10-15 characters): Phone number initiating the call.
- **B\_NUM** (10-15 characters): Phone number being called.
- **STT\_TIME** (14 characters): Call start timestamp (YYYYMMDDHHMISS).
- **END\_TIME** (14 characters): Call end timestamp (YYYYMMDDHHMISS).
- **CALL\_TYPE** (1 character): Type of the call (`P`, `S`, `M`).
- **CALL\_COST** (5 characters): Cost of the call in sen.

Example:

```
46001122 60123008888 60163005555 2020100113503020201001135500P15
46002255 60126001234 60162006789 2020100113553020201001142000P75
```

## How to Compile and Execute

1. Compile the program using the following command:
   javac CallReportGenerator.java

2. Execute the program with the path to the input file:
   java CallReportGenerator \<input\_file\_path>

## Output

The program generates a report file named `<input_file_name>_REPORT.TXT` in the same directory as the input file. The report contains:

- Total cost of calls per account.
- Total cost of calls per call type.
- Total cost of calls per day.

### Example

Input file: `012.20250101.TXT`
Execution:
java CallReportGenerator 012.20250101.TXT

Output file: `012.20250101_REPORT.TXT`

```
Report Generated:

Total Cost by Account:
Account: 46001122, Total Cost: 15
Account: 46002255, Total Cost: 75

Total Cost by Call Type:
Call Type: P, Total Cost: 90

Total Cost by Day:
Day: 20250101, Total Cost: 90
```

## Requirements

- JDK 8 or higher.
- Valid input file in the specified format.

