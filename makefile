JAVA_COMPILER = javac -cp build -implicit:none -d build
JAVA_RUN = java

BIN_DIR = bin
SRC_DIR = src

all:
	$(JAVA_COMPILER) -d $(BIN_DIR) $(SRC_DIR)/*.java

run: all
	$(JAVA_RUN) -cp $(BIN_DIR) App

clean:
	rm -rf $(BIN_DIR)

doc:
	javadoc -d doc $(SRC_DIR)/*.java