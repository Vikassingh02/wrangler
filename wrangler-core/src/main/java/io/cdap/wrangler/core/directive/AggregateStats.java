public class AggregateStats implements Directive {
    private String byteColumn, timeColumn, resultByte, resultTime;
    private long totalBytes = 0, totalMillis = 0;

    @Override
    public void initialize(DirectiveContext ctx, Arguments args) {
        byteColumn = args.value("byte_column");
        timeColumn = args.value("time_column");
        resultByte = args.value("result_bytes");
        resultTime = args.value("result_time");
    }

    @Override
    public List<Row> execute(List<Row> rows, ExecutorContext ctx) {
        for (Row row : rows) {
            ByteSize b = new ByteSize((String) row.getValue(byteColumn));
            TimeDuration t = new TimeDuration((String) row.getValue(timeColumn));
            totalBytes += b.getBytes();
            totalMillis += t.getMilliseconds();
        }
        Row result = new Row();
        result.add(resultByte, totalBytes / (1024.0 * 1024.0)); // MB
        result.add(resultTime, totalMillis / 1000.0); // seconds
        return Collections.singletonList(result);
    }

    @Override
    public UsageDefinition define() {
        return UsageDefinition.builder()
            .define("byte_column", TokenType.COLUMN_NAME)
            .define("time_column", TokenType.COLUMN_NAME)
            .define("result_bytes", TokenType.COLUMN_NAME)
            .define("result_time", TokenType.COLUMN_NAME)
            .build();
    }
}
