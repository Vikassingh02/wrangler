YTE_SIZE: DIGITS BYTE_UNIT;
TIME_DURATION: DIGITS TIME_UNIT;

fragment BYTE_UNIT: ('B' | 'KB' | 'MB' | 'GB' | 'TB');
fragment TIME_UNIT: ('ms' | 's' | 'm' | 'h');
fragment DIGITS: [0-9]+('.'[0-9]+)?;
