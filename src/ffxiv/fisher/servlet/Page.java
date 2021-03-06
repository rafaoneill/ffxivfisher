package ffxiv.fisher.servlet;


/**
 * Enum describing page meta-data.
 */
public enum Page {

	FISHER("fisher.html", "fisher.js", "fisher.css");
	
	private final String htmlFilePath;
	private final String jsFilePath;
	private final String cssFilePath;

	private Page(String htmlFileName, String jsFileName, String cssFileName) {
		this.htmlFilePath = htmlFileName;
		this.jsFilePath = "/generated/" + jsFileName;
		this.cssFilePath = "/generated/" + cssFileName;
	}
	
	public String getHtmlFilePath(ServingMode servingMode) {
		return servingMode == ServingMode.DEV ? "dev-" + htmlFilePath : htmlFilePath;
	}
	
	public String getJsFilePath(String frontendVersion) {
		return jsFilePath + "?v=" + frontendVersion;
	}
	
	public String getCssFilePath(String frontendVersion) {
		return cssFilePath + "?v=" + frontendVersion;
	}
}