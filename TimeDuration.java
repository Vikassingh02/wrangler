public class TimeDuration extends Token {
    private long milliseconds;

    public TimeDuration(String input) {
        super(input);
        this.milliseconds = parseDuration(input);
    }

    private long parseDuration(String input) {
        input = input.trim().toLowerCase();
        if (input.endsWith("ms")) return (long)(Double.parseDouble(input.replace("ms", "")));
        if (input.endsWith("s")) return (long)(Double.parseDouble(input.replace("s", "")) * 1000);
        if (input.endsWith("m")) return (long)(Double.parseDouble(input.replace("m", "")) * 60000);
        if (input.endsWith("h")) return (long)(Double.parseDouble(input.replace("h", "")) * 3600000);
        throw new IllegalArgumentException("Unsupported time format: " + input);
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public double getSeconds() {
        return milliseconds / 1000.0;
    }
}
