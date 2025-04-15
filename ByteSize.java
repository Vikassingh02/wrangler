public class ByteSize extends Token {
    private long bytes;

    public ByteSize(String input) {
        super(input);
        this.bytes = parseBytes(input);
    }

    private long parseBytes(String input) {
        input = input.trim().toUpperCase();
        if (input.endsWith("KB")) return (long)(Double.parseDouble(input.replace("KB", "")) * 1024);
        if (input.endsWith("MB")) return (long)(Double.parseDouble(input.replace("MB", "")) * 1024 * 1024);
        if (input.endsWith("GB")) return (long)(Double.parseDouble(input.replace("GB", "")) * 1024 * 1024 * 1024);
        if (input.endsWith("TB")) return (long)(Double.parseDouble(input.replace("TB", "")) * 1024L * 1024 * 1024 * 1024);
        if (input.endsWith("B")) return Long.parseLong(input.replace("B", ""));
        throw new IllegalArgumentException("Unsupported byte format: " + input);
    }

    public long getBytes() {
        return bytes;
    }
}
