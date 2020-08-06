package bg.softuni.proxies.pattern;

public class ProxieGreeter implements GreeterIfc {

    private final GreeterIfc delegate;

    public ProxieGreeter(GreeterIfc delegate) {
        this.delegate = delegate;
    }

    @Override
    public void greet() {
        System.out.println("Before execution.");
        delegate.greet();
        System.out.println("After execution.");
    }
}
