package de.hsesslingen.StudienprojektKneisel.WebConfig;

public class ExtensionAppendInterceptor extends PathForwardHandlerInterceptor {
    @Override
    protected String provideAlternative(String path) {
        return ("/".equals(path) || path.contains(".")) ? null : path + ".html";
    }
}