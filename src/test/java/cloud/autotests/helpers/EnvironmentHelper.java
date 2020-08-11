package cloud.autotests.helpers;

import static java.lang.Boolean.parseBoolean;


public class EnvironmentHelper {

    public static final String
        screenResolution = System.getProperty("screen_resolution", "1360x768"),
        webMobileDevice = System.getProperty("web_mobile_device"),
//        webMobileDevice = System.getProperty("web_mobile_device", "iPhone X");
        remoteDriverUrl = System.getProperty("remote_driver_url"), // https://username:password@selenoid.autotests.cloud:4444/wd/hub/
        videoStorageUrl = System.getProperty("video_storage_url"); // https://selenoid.autotests.cloud/video/
    public static final boolean
        isHeadless = parseBoolean(System.getProperty("headless", "false")),
        isWebMobile = webMobileDevice != null,
        isRemoteDriver = remoteDriverUrl != null,
        isVideoOn = videoStorageUrl != null;

// CI CONFIG (jenkins)
    public static final String
            buildNumber = System.getProperty("build_number", "0"),
            jobBaseName = System.getProperty("job_base_name", "local");
}
