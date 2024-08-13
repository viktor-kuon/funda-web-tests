package nl.funda.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class WebElementDecorator implements FieldDecorator {
    private final ElementLocatorFactory factory;

    public WebElementDecorator(WebElement rootElement) {
        this.factory = new DefaultElementLocatorFactory(rootElement);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!WebElement.class.isAssignableFrom(field.getType())) {
            return null;
        }

        InvocationHandler handler = new LocatingElementHandler(factory.createLocator(field));
        return Proxy.newProxyInstance(loader, new Class[]{field.getType()}, handler);
    }
}
