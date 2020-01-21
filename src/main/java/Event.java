import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Event extends Task {
    public static final String USAGE = "event description /at event_time";
    private String eventTime;
    private static Pattern messageRegex = Pattern.compile("event\\s+(\\S+.*)\\s+/at\\s+(\\S+.*)");

    public static Event parseEvent(String msg) throws MessageInterpretationException {
        Matcher m = messageRegex.matcher(msg);
        
        if (m.matches()) {
            return new Event(m.group(1), m.group(2));
        } else {
            throw new MessageInterpretationException(USAGE);
        }
    }

    public Event(String details, String eventTime) {
        super(details);
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + String.format(" (at: %s)", eventTime);
    }
}