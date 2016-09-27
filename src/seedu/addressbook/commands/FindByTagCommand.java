package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

/**
 * Finds and lists all persons in address book whose tag(s) contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */

public class FindByTagCommand extends Command {
    
    public static final String COMMAND_WORD = "findtag";
    
    public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Finds all persons who are tagged with any of  "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n\t"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n\t"
            + "Example: " + COMMAND_WORD + " friends acquaintances colleagues";
    
    private final Set<String> keywords;
    
    public FindByTagCommand(Set<String> keywords) {
        this.keywords = keywords;
    }
    
    /**
     * Returns copy of keywords in this command.
     */
    public Set<String> getKeywords() {
        return new HashSet<>(keywords);
    }
    
    @Override
    public CommandResult execute() {
        final List<ReadOnlyPerson> personsFound = getPersonsWithTagContainingAnyKeyword(keywords);
        return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound); //May need to edit this
    }
    
    /**
     * Retrieve all persons in the address book whose tag(s) contain some of the specified keywords.
     *
     * @param keywords for searching
     * @return list of persons found
     */
    private List<ReadOnlyPerson> getPersonsWithTagContainingAnyKeyword(Set<String> keywords) {
        final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : addressBook.getAllPersons()) {
            ArrayList<String> tags = new ArrayList<String>();
            Iterator<Tag> tagIterator = person.getTags().iterator();
            while(tagIterator.hasNext()) {
                tags.add(tagIterator.next().tagName);
            }
            if (!Collections.disjoint(tags, keywords)) {
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
