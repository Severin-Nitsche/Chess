project:
	find src -name "*.java" | xargs javac --enable-preview --release 15 -d out/production --module-source-path src

test: project
	java --enable-preview --module-path out/production --module com.github.severinnitsche.Chess/com.github.severinnitsche.chess.Engine
