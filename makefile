JAVA_COMPILER = javac
JAVA_RUN = java

BIN_DIR = bin
SRC_DIR = src

all: 
	$(JAVA_COMPILER) -d $(BIN_DIR) $(SRC_DIR)/*.java src/star/*.java

run: all
	$(JAVA_RUN) -cp $(BIN_DIR) App

clean:
	rm -rf $(BIN_DIR)

doc:
	javadoc -d doc $(SRC_DIR)/*.java

jar: all
	cd bin && jar cvfm P4.jar ../META-INF/MANIFEST.MF * ../res/