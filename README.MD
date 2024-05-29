# LittlePay Trip Processor
This system will take a CSV file that represents the customer taps transaction 
at various bus stop and produce a trips CSV file. 


# JAR/Test data/Test Suite location
   - A test taps.csv file is located in /data folder
   - A pre-built JAR file i.e. littlepay.jar is located in /out/artifacts/little_jar/ folder
   - The unit test suite is located in /src/test folder
    
# Running the program
   - java -jar littlepay.jar data/taps.csv
   - The output file trips.csv will be located where the command is executed
   - A sample result file trips.csv that corresponds to the sample taps.csv is located 

# Assumptions
  - The taps.csv file is well formed 
    - Customers are identified by their unique PAN (credit card number)
    - A Tap On must occur before a Tap Off for each customer
    - A Tap On without a Tap Off in the CSV file is considered Incomplete
    - A Tap On followed by another Tap On is considered Incomplete too
    - All data are well formatted
   - Incomplete trip will have 0 duration, empty ToStopId and Finished
    time 
    
# Libraries used 
    - opencsv - CSV file parsing and printing  
    - guava - Advanced Collection
    - junit - Unit testing
