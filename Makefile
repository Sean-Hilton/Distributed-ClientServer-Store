
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
    common/Idepartment.java \
    common/IItem.java \
    common/Icommand.java \
	server/Iuser.java \
	server/AdminView.java \
	server/ShopperView.java \
	server/Store_Model.java \
	server/Dispatcher.java \
        server/Department.java \
	server/Item.java \
	server/RemoteAccount.java \
    	server/Shopper.java \
    	server/System_Admin.java \
    	server/UserFactory.java \
    	server/UpdateItemCommand.java \
    	server/AddItemCommand.java \
    	server/BrowseItemsCommand.java \
    	client/StoreClient.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class