project:
	find src -name "*.java" | xargs javac --enable-preview --release 15 -d out/production --module-path "lib/reverie/AlgebraicDataTypes.jar:lib/reverie/fantasyland.jar:lib/reverie/Function.jar:lib/reverie/Dreamer.jar" --module-source-path src

test: project
	java --enable-preview --module-path "out/production:lib/reverie/AlgebraicDataTypes.jar:lib/reverie/fantasyland.jar:lib/reverie/Function.jar:lib/reverie/Dreamer.jar" --module com.github.severinnitsche.Chess/com.github.severinnitsche.chess.Engine
