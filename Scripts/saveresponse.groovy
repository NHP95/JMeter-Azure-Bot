import java.io.File;
import org.apache.jmeter.services.FileServer;
 
//get current jmeter script's directory
def path = FileServer.getFileServer().getBaseDir();

//get the separator
def separator = File.separator;
def text = prev.getResponseDataAsString().replaceAll("[\\\r\\\n]+", "");
def code = prev.getResponseCode();
def latency = prev.getLatency();
def threadName = prev.getThreadName();
def sampleLabel = prev.getSampleLabel();
File file = new File("${separator}${args[0]}logs-${args[1]}.csv");
file.append("${threadName},${sampleLabel},${code},${latency}\n");
