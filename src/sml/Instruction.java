package sml;

/**
 * Abstract instruction class.
 *
 * Represents an instruction for SML. Implemented by various instruction types.
 *
 * @author Joe Warriner
 */
public abstract class Instruction {
	protected final String label;
	protected final String opcode;

	/**
	 * Constructor: an instruction with a label and an opcode
	 * (opcode must be an operation of the language)
	 *
	 * @param label optional label (can be null)
	 * @param opcode operation name
	 */
	public Instruction(String label, String opcode) {
		this.label = label;
		this.opcode = opcode;
	}

	/**
	 * Returns the operation label.,
	 * @return operation label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Returns the opcode.
	 * @return opcode
	 */
	public String getOpcode() {
		return opcode;
	}


	public static int NORMAL_PROGRAM_COUNTER_UPDATE = -1;

	/**
	 * Executes the instruction in the given machine.
	 *
	 * @param machine the machine the instruction runs on
	 * @return the new program counter (for jump instructions)
	 *          or NORMAL_PROGRAM_COUNTER_UPDATE to indicate that
	 *          the instruction with the next address is to be executed
	 */

	public abstract int execute(Machine machine);

	protected String getLabelString() {
		return (getLabel() == null) ? "" : getLabel() + ": ";
	}

	/*
	Subclasses must provide implementations of methods that are declared as abstract.
	(Or be abstract classes themselves).
	In practice this means that subclasses of Instruction must override toString.
	 */
	@Override
	public abstract String toString();


	// These aren't actually necessary for the programme to work, so I haven't implemented.

	// public abstract boolean equals();
	// public abstract int hashCode();

}
