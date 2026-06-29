SET SERVEROUTPUT ON;

BEGIN

    FOR loan IN
    (
        SELECT LoanID,
               CustomerID,
               DueDate

        FROM Loans

        WHERE DueDate
        BETWEEN SYSDATE
        AND SYSDATE+30
    )

    LOOP

        DBMS_OUTPUT.PUT_LINE(

        'Reminder : Customer '

        ||loan.CustomerID||

        ' Loan ID '

        ||loan.LoanID||

        ' Due on '

        ||loan.DueDate

        );

    END LOOP;

END;
/
