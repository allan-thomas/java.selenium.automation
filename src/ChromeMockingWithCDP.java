import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.fetch.Fetch;
import org.openqa.selenium.devtools.v139.fetch.model.HeaderEntry;

public class ChromeMockingWithCDP {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\allan\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));

		devTools.addListener(Fetch.requestPaused(), request -> {
			// Convert headers to List<HeaderEntry>
			Optional<List<HeaderEntry>> headerEntries = Optional.of(
					request.getRequest().getHeaders().toJson().entrySet().stream()
							.map(e -> new HeaderEntry(e.getKey(), e.getValue().toString()))
							.collect(Collectors.toList())
			);

			if (request.getRequest().getUrl().contains("shetty")) {
				String mockedURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedURL);
				devTools.send(Fetch.continueRequest(
						request.getRequestId(),
						Optional.ofNullable(mockedURL),
						Optional.ofNullable(request.getRequest().getMethod()),
						Optional.empty(),
						headerEntries,
						Optional.of(true)
				));
			} else {
				devTools.send(Fetch.continueRequest(
						request.getRequestId(),
						Optional.empty(),
						Optional.ofNullable(request.getRequest().getMethod()),
						Optional.empty(),
						headerEntries,
						Optional.of(true)
				));
			}
		});
	}
}
