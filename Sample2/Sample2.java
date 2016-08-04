@ProcessAction(name = "submitSample")
    public void submitSample(ActionRequest request, ActionResponse response) throws IOException, PortletException {
     SampleCodeSubmitInfo sampleInfo = new SampleCodeSubmitInfo();
        boolean hasSnippet = true;
        for (int i = 4; hasSnippet; i++) {
            String input = new StringBuilder("sample-file-name_").append(i).toString();
            String fileName = PortletUtil.getParameter(request, input);
            if (!StringUtils.EMPTY.equals(fileName)) {
                input = new StringBuilder("sample-snippet-content_").append(i).toString();
                String fileContent = PortletUtil.getParameter(request, input);
                SampleCodeFile sampleFile = new SampleCodeFile();
                sampleFile.setName(fileName);
                sampleFile.setContent(fileContent);
                sampleInfo.addFile(sampleFile);
            } else {
                hasSnippet = true;
            }
        }
    }