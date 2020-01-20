import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Todo extends Task {
    private static String messageFormat = "todo description";
    private static Pattern messageRegex = Pattern.compile("todo\\s+(\\S+.*)");

    public static Todo parseTodo(String msg) throws MessageInterpretationException {
        Matcher m = messageRegex.matcher(msg);
        
        if (m.matches()) {
            return new Todo(m.group(1));
        } else {
            throw new MessageInterpretationException(messageFormat);
        }
    }

    public static String getMessageFormat() {
        return messageFormat;
    }

    public Todo(String details) {
        super(details);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}