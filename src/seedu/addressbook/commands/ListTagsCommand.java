package seedu.addressbook.commands;

import seedu.addressbook.data.tag.Tag;

import java.util.List;


/**
 * Lists all tags in the address book to the user.
 */
public class ListTagsCommand extends Command {

    public static final String COMMAND_WORD = "listTags";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" 
            + "Displays all tags in the address book as a list with index numbers.\n\t"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<Tag> allTags = addressBook.getAllTags().immutableListView();
        return new CommandResult(getMessageForTagListShownSummary(allTags), allTags, true);
    }
}
