package seedu.addressbook.commands;
import seedu.addressbook.data.person.*;
import java.util.Iterator;

/**
 * Finds the person by contact number.
 */

public class FindByContactCommand extends Command{
    public Name targetName;
    UniquePersonList allPersons = addressBook.getAllPersons();
    Iterator<Person> itr = allPersons.iterator();

    public static final String COMMAND_WORD = "findPersonByNumber";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Finds the person by contact number and displays the name of the person.\n\t"
            + "Example: " + COMMAND_WORD+ " 99814141";

    public static final String MESSAGE_SUCCESS = "Found person!";

    public FindByContactCommand(int num) {
        findPerson(num);
    }
    public boolean findPerson(int num){
        if( Integer.parseInt(((ReadOnlyPerson) itr).getPhone().value)==num){
            targetName=((ReadOnlyPerson) itr).getName();
            return true;
        }
        return false;
    }
    @Override
    public CommandResult execute(){
        return new CommandResult(String.format(MESSAGE_SUCCESS, targetName));

    }
}
