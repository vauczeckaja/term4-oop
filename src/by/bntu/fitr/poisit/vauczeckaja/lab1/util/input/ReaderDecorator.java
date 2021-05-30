package by.bntu.fitr.poisit.vauczeckaja.lab1.util.input;

public class ReaderDecorator implements Reader {
    protected Reader wrapper;

    ReaderDecorator(Reader wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public String read() {
        return wrapper.read();
    }

    @Override
    public String read(String request) {
        return wrapper.read(request);
    }
}
