import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Validator {

    private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static int GROUPSQUANTITY = 6;
    private static String STRINGREGEX = "[a-zA-Z0-9_ ]+";
    private static String GENDERREGEX = "[f|m]";
    private static String SIZEREGEX = "[s|m|b]";
    private static String OWNERREGEX = "[a-zA-Z ]+";
    private static String FORMAT_ILLEGAL = " format illegal: ";

    protected String[] verifyData(String userData) throws WrongAmountOfDataException, NotClearDataException {
        final String COLONREGEX = ":";

        // Splitting a string on a colon
        Pattern spacePattern = Pattern.compile(COLONREGEX);
        String[] rawData = spacePattern.split(userData);

        // Checking the amount of data
        try {
            if (rawData.length != GROUPSQUANTITY) {
                throw new WrongAmountOfDataException();
            }
            // Trim trailing spaces
            for (int i = 0; i < rawData.length; i++) {
                rawData[i] = rawData[i].trim();
            }

            checkDataFormat(rawData);
        } catch (PatternSyntaxException e) {
            System.out.println("PatternSyntaxException");
            System.out.println(e.getMessage());
            throw new NotClearDataException();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("IllegalArgumentException | IllegalStateException");
            System.out.println(e.getMessage());
            throw new NotClearDataException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            System.out.println(e.getMessage());
        }
        return rawData;
    }

    private static void checkDataFormat(String[] data) throws IllegalArgumentException {
        /* Parsing data */
        String BIRTHDAY_ERROR_MSG = "Birthday";
        String OWNER_ERROR_MSG = "Owner data (last name, first name, patronymic)";

        String errors = "";

        HashMap<String, String> regexes = new HashMap<>();
        regexes.put("name", STRINGREGEX);
        regexes.put("commands", STRINGREGEX);
        regexes.put("gender", GENDERREGEX);
        regexes.put("size", SIZEREGEX);
        regexes.put("ownerFio", OWNERREGEX);

        HashMap<String, String> rawData = new HashMap<>();
        rawData.put("name", data[0]);
        rawData.put("commands", data[1]);
        rawData.put("birthday", data[2]);
        rawData.put("gender", data[3]);
        rawData.put("size", data[4]);
        rawData.put("ownerFio", data[5]);

        // Iterating over the regexes HashMap in a loop
        for (Map.Entry<String, String> entry : regexes.entrySet()) {

            String key = entry.getKey();
            String errKey = key.substring(0, 1).toUpperCase() + key.substring(1);
            String regex = entry.getValue();

            // If value from rawData does not match the regular expression
            if (!rawData.get(key).matches(regex)) {
                if (key.equals("ownerFio")) {
                    errKey = OWNER_ERROR_MSG;
                }
                errors += errKey + FORMAT_ILLEGAL + rawData.get(key) + "\n";
            }

        }

        try {
            validateBirthday(rawData.get("birthday"));
        } catch (ParseException | IllegalArgumentException e) {
            errors += BIRTHDAY_ERROR_MSG + FORMAT_ILLEGAL + rawData.get("birthday") + "\n";
        }

        if (!errors.isEmpty()) {
            System.out.println("Errors appeared");
            throw new IllegalArgumentException(errors);
        }

    }

    private static void validateBirthday(String rawBirthDate) throws ParseException, IllegalArgumentException {
        /* Validate birthday */
        Date birthDate = new Date();
        Date currentDay = new Date();

        // Current Tue Jul 11 14:20:54 UTC 2023 Date => Into string "11.07.2023"
        String currentDayString = dateFormat.format(currentDay);

        // Check date format
        dateFormat.setLenient(false);
        // str => date
        birthDate = dateFormat.parse(rawBirthDate);
        currentDay = dateFormat.parse(currentDayString);

        // Check incorrect date: Was the animal born in the future?
        if (birthDate.getTime() > currentDay.getTime()) {
            throw new IllegalArgumentException();
        }

    }

    protected void validateAnimalName(String name) {
        if ((!name.matches(STRINGREGEX)) || (name.isEmpty())) {
            throw new IllegalArgumentException("Name" + FORMAT_ILLEGAL + name);
        }
    }

    protected void validateAdditionalCommands(String commands) {
        if ((!commands.matches(STRINGREGEX)) || (commands.isEmpty())) {
            throw new IllegalArgumentException("Commands" + FORMAT_ILLEGAL + commands);
        }
    }

}
