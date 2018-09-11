JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	BJ.java \
	Card.java \
	Deck.java \
	UI.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class