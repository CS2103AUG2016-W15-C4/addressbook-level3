package seedu.addressbook.commands;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.tag.Tag;

import java.util.List;
import java.util.Optional;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    /** The feedback message to be shown to the user. Contains a description of the execution result */
    public final String feedbackToUser;

    /** The list of persons that was produced by the command */
    private final List<? extends ReadOnlyPerson> relevantPersons;

    /** The list of tags that was produced by the command */
    private final List<? extends Tag> relevantTags;
    
    /** Indicates whether is it tags or not */
    public boolean tag;

    public CommandResult(String feedbackToUser) {
        this.feedbackToUser = feedbackToUser;
        relevantPersons = null;
        relevantTags = null;
        tag = false;
    }

    public CommandResult(String feedbackToUser, List<? extends ReadOnlyPerson> relevantPersons) {
        this.feedbackToUser = feedbackToUser;
        this.relevantPersons = relevantPersons;
        relevantTags = null;
        tag = false;
    }
    
    public CommandResult(String feedbackToUser, List<? extends Tag> relevantTags, boolean tag) {
        this.feedbackToUser = feedbackToUser;
        this.relevantTags = relevantTags;
        this.tag = tag;
        relevantPersons = null;
    }

    /**
     * Returns list of persons relevant to the command command result, if any.
     */
    public Optional<List<? extends ReadOnlyPerson>> getRelevantPersons() {
        return Optional.ofNullable(relevantPersons);
    }
    
    /**
     * Returns list of tags relevant to the command command result, if any.
     */
    public Optional<List<? extends Tag>> getRelevantTags() {
        return Optional.ofNullable(relevantTags);
    }

}
