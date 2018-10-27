
package test.com.challenge.spreadsheet;

import com.challenge.spreadsheet.Cell;
import com.challenge.spreadsheet.Spreadsheet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author siddharth
 */
public class SpreadsheetTest {
    
    private Spreadsheet sp;
    
    public SpreadsheetTest() {
        
    }
    
    @Before
    public void setUp() {
        sp = new Spreadsheet();
    }
    
    @After
    public void tearDown() {
        sp = null;
    }

    @Test
    public void testCalculateCell() throws Exception {
        
        
    }
    
}
