package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

/**
 * Finds and lists all persons in address book whose address contains any of the argument keywords.
 * Keyword matching is case sensitive.
 */
public class FindByAddressCommand extends Command {


	public static final String COMMAND_WORD = "findAddress";

	public static final String MESSAGE_USAGE = COMMAND_WORD + ":\n" + "Finds all persons who have these address  "
			+ " and displays them as a list with index numbers.\n\t"
			+ "Parameters: KEYWORD [MORE_KEYWORDS]...\n\t"
			+ "Example: " + COMMAND_WORD + " New Gate";

	private final Set<String> keywords;

	//Constructor
	public FindByAddressCommand(Set<String> keywords) {
		this.keywords = keywords;
	}

	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		final List<ReadOnlyPerson> personsFound = getPersonsWithAddressContainingAnyKeyword(keywords);
		return new CommandResult(getMessageForPersonListShownSummary(personsFound), personsFound);
	}

	/**
	 * Retrieve all persons in the address book whose Address contain some of the specified keywords.
	 * 
	 * @param keywords for searching
	 *  @return list of persons found
	 */
	private List<ReadOnlyPerson> getPersonsWithAddressContainingAnyKeyword(Set<String> keywords2) {
		// TODO Auto-generated method stub
		final List<ReadOnlyPerson> matchedPersons = new ArrayList<>();
		for (ReadOnlyPerson person : addressBook.getAllPersons()) {
			final Set<String> wordsInAddress = new HashSet<>(person.getAddress().getAddressInName());
			if (!Collections.disjoint(wordsInAddress, keywords2)) {
				matchedPersons.add(person);
			}
		}
		return matchedPersons;
	}
}
