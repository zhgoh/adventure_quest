ifdef OS
	RM = del /Q
	FixPath = $(subst /,\,$1)
	CLS = cls
else
   ifeq ($(shell uname), Linux)
		RM = rm -f
		FixPath = $1
		CLS = clear
   endif
endif

all: app
	$(CLS)
	java -cp bin AdventureQuest

app: src/AdventureQuest.java
	javac -sourcepath ./src ./src/AdventureQuest.java -d bin

jar: bin/guide/cli/*.class app
	cd bin && jar cfm AdventureQuest.jar manifest.txt ./src/*.class

clean:
	$(RM) $(call FixPath, bin/*.class)
	$(RM) $(call FixPath, bin/*.jar)
