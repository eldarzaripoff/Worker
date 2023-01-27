public class Worker {
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    public interface OnTaskErrorListener {
        void onError(String result);
    }
    private OnTaskDoneListener callback;
    public OnTaskErrorListener errorCallback;
    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }
    public void start() {
        for(int i = 0; i < 100; i++) {
            if(i == 33) {
                errorCallback.onError("Task " + i + " UNDONE");
            } else {
        callback.onDone("Task " + i + " done");
            }
        }
    }
}
