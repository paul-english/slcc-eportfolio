package payrollsystemmodification;

/**
 * An employee whose pay is based on the number of pieces of merchandise
 * produced.
 *
 * @author nrub
 * TODO
 */
public class PieceWorker extends Employee {

    /**
     * The employee’s wage per piece
     * TODO
     */
    private double wage;

    /**
     * The number of pieces produced
     * TODO
     */
    private double pieces;

    /**
     * TODO
     */
    public PieceWorker(String first, String last, String ssn, double wage,
            double pieces) {
        super(first, last, ssn);
        setWage(wage);
        setPieces(pieces);
    }

    /**
     * TODO
     */
    public double getWage()
    {
        return wage;
    }

    /**
     * TODO
     */
    public void setWage(double pieceWage)
    {
        wage = pieceWage;
    }

    /**
     * TODO
     */
    public double getPieces()
    {
        return pieces;
    }

    /**
     * TODO
     */
    public void setPieces(double numberPieces)
    {
        pieces = numberPieces;
    }

    /**
     * Calculates the employee’s earnings
     * TODO
     * @return
     */
    @Override
    public double earnings()
    {
        return pieces * wage;
    }

    /**
     * TODO
     * @return String representation of SalariedEmployee object
     */
    @Override
    public String toString()
    {
        return String.format("piece worker: %s\n%s: $%,.2f; %s: %,.2f",
                super.toString(), "wage", getWage(), "pieces", getPieces());
    } // end method toString
}
