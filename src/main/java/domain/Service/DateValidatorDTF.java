package domain.Service;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidatorDTF implements DateValidator{


    private final DateTimeFormatter dateFormatter;

    public DateValidatorDTF (DateTimeFormatter dateFormatter) {
        this.dateFormatter=dateFormatter;
    }

    @Override
    public boolean isValid(String dateStr) {
        try {
            this.dateFormatter.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
