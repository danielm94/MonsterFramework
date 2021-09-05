package shared_utilities.report_utility;

import shared_utilities.data_readers.PropertyReader;
import shared_utilities.data_readers.property_file.FrameworkPropertyFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {
    public static String getTimeStamp() {
        String timeStampFormat = PropertyReader.getProperty(FrameworkPropertyFile.GLOBAL_PROPERTIES, "timeStampFormat");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(timeStampFormat);
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
