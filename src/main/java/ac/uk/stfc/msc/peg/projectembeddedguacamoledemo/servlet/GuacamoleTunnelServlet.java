package ac.uk.stfc.msc.peg.projectembeddedguacamoledemo.servlet;

import org.apache.guacamole.GuacamoleException;
import org.apache.guacamole.net.GuacamoleSocket;
import org.apache.guacamole.net.GuacamoleTunnel;
import org.apache.guacamole.net.InetGuacamoleSocket;
import org.apache.guacamole.net.SimpleGuacamoleTunnel;
import org.apache.guacamole.protocol.ConfiguredGuacamoleSocket;
import org.apache.guacamole.protocol.GuacamoleConfiguration;
import org.apache.guacamole.servlet.GuacamoleHTTPTunnelServlet;

import javax.servlet.http.HttpServletRequest;

public class GuacamoleTunnelServlet extends GuacamoleHTTPTunnelServlet {

    @Override
    protected GuacamoleTunnel doConnect(HttpServletRequest httpServletRequest) throws GuacamoleException {
        GuacamoleConfiguration configuration = new GuacamoleConfiguration();
        configuration.setProtocol("rdp");
        configuration.setParameter("hostname", "ec2-52-214-60-143.eu-west-1.compute.amazonaws.com");
        configuration.setParameter("port", "4821");
        configuration.setParameter("user", "dev");
        configuration.setParameter("password", "dev");

        GuacamoleSocket socket = new ConfiguredGuacamoleSocket(
                new InetGuacamoleSocket("ec2-52-214-60-143.eu-west-1.compute.amazonaws.com", 4822),
                configuration
        );

        return new SimpleGuacamoleTunnel(socket);
    }
}
