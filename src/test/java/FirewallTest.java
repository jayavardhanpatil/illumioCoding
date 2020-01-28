
import com.illumio.coding.Firewall;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by jayavardhanpatil on 1/27/20
 */

public class FirewallTest {
    Firewall firewall;

    @Before
    public void BeforeTest() throws IOException {
        firewall = new Firewall("ruleData.csv");
    }

    @Test
    public void testCaseMatchingFirstRule() {
        assertEquals(true, firewall.accept_packet("inbound", "tcp", 80, "192.168.1.2"));
    }

    @Test
    public void testCaseMatchingThirdRule() {
        assertEquals(true, firewall.accept_packet("inbound", "udp", 53, "192.168.2.1"));
    }

    @Test
    public void testCaseSecondRule() {
        assertEquals(true, firewall.accept_packet("outbound", "tcp", 10234, "192.168.10.11"));
    }

    @Test
    public void testCase_Wrong_IpAddr() {
        assertEquals(false, firewall.accept_packet("inbound", "udp", 24, "52.12.48.92"));
    }

    @Test
    public void testCase_WrongData() {
        assertEquals(false, firewall.accept_packet("inbound", "tcp", 81, "192.168.1.2"));
    }
}
