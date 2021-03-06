/*
 * Copyright 2005 The Apache Software Foundation.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
/*
 * Copyright 2005 Sun Microsystems, Inc. All rights reserved.
 */
/*
 * $Id: DOMCryptoContext.java 375655 2006-02-07 18:35:54Z mullan $
 */
package javax.xml.crypto.dom;

import javax.xml.crypto.KeySelector;
import javax.xml.crypto.URIDereferencer;
import javax.xml.crypto.XMLCryptoContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.w3c.dom.Element;

/**
 * This class provides a DOM-specific implementation of the
 * {@link XMLCryptoContext} interface. It also includes additional
 * methods that are specific to a DOM-based implementation for registering
 * and retrieving elements that contain attributes of type ID. 
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class DOMCryptoContext implements XMLCryptoContext {

    private HashMap nsMap = new HashMap();
    private HashMap idMap = new HashMap();
    private HashMap objMap = new HashMap();
    private String baseURI;
    private KeySelector ks;
    private URIDereferencer dereferencer;
    private HashMap propMap = new HashMap();
    private String defaultPrefix;

    /**
     * Default constructor. (For invocation by subclass constructors).
     */
    protected DOMCryptoContext() {}

    /**
     * This implementation uses an internal {@link HashMap} to get the prefix 
     * that the specified URI maps to. It returns the <code>defaultPrefix</code>
     * if it maps to <code>null</code>.
     *
     * @throws NullPointerException {@inheritDoc}
     */
    public String getNamespacePrefix(String namespaceURI, 
	String defaultPrefix) {
        if (namespaceURI == null) {
            throw new NullPointerException("namespaceURI cannot be null");
        }
	String prefix = (String) nsMap.get(namespaceURI);
	return (prefix != null ? prefix : defaultPrefix);
    }

    /**
     * This implementation uses an internal {@link HashMap} to map the URI
     * to the specified prefix.
     *
     * @throws NullPointerException {@inheritDoc}
     */
    public String putNamespacePrefix(String namespaceURI, String prefix) {
        if (namespaceURI == null) {
            throw new NullPointerException("namespaceURI is null");
        }
        return (String) nsMap.put(namespaceURI, prefix);
    }

    public String getDefaultNamespacePrefix() {
	return defaultPrefix;
    }

    public void setDefaultNamespacePrefix(String defaultPrefix) {
	this.defaultPrefix = defaultPrefix;
    }

    public String getBaseURI() {
        return baseURI;
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    public void setBaseURI(String baseURI) {
	if (baseURI != null) {
	    java.net.URI.create(baseURI);
	}
        this.baseURI = baseURI;
    }

    public URIDereferencer getURIDereferencer() {
        return dereferencer;
    }

    public void setURIDereferencer(URIDereferencer dereferencer) {
        this.dereferencer = dereferencer;
    }

    /**
     * This implementation uses an internal {@link HashMap} to get the object 
     * that the specified name maps to. 
     *
     * @throws NullPointerException {@inheritDoc}
     */
    public Object getProperty(String name) {
        if (name == null) {
            throw new NullPointerException("name is null");
        }
        return propMap.get(name);
    }

    /**
     * This implementation uses an internal {@link HashMap} to map the name
     * to the specified object.
     *
     * @throws NullPointerException {@inheritDoc}
     */
    public Object setProperty(String name, Object value) {
        if (name == null) {
            throw new NullPointerException("name is null");
        }
        return propMap.put(name, value);
    }

    public KeySelector getKeySelector() {
        return ks;
    }

    public void setKeySelector(KeySelector ks) {
        this.ks = ks;
    }

    /**
     * Returns the <code>Element</code> with the specified ID attribute value.
     *
     * <p>This implementation uses an internal {@link HashMap} to get the 
     * element that the specified attribute value maps to. 
     *
     * @param idValue the value of the ID
     * @return the <code>Element</code> with the specified ID attribute value,
     *    or <code>null</code> if none.
     * @throws NullPointerException if <code>idValue</code> is <code>null</code>
     * @see #setIdAttributeNS
     */
    public Element getElementById(String idValue) {
        if (idValue == null) {
            throw new NullPointerException("idValue is null");
        }
        return (Element) idMap.get(idValue);
    }

    /**
     * Registers the element's attribute specified by the namespace URI and
     * local name to be of type ID. The attribute must have a non-empty value.
     *
     * <p>This implementation uses an internal {@link HashMap} to map the 
     * attribute's value to the specified element.
     *
     * @param element the element
     * @param namespaceURI the namespace URI of the attribute (specify
     *    <code>null</code> if not applicable)
     * @param localName the local name of the attribute
     * @throws IllegalArgumentException if <code>localName</code> is not an
     *    attribute of the specified element or it does not contain a specific
     *    value
     * @throws NullPointerException if <code>element</code> or
     *    <code>localName</code> is <code>null</code>
     * @see #getElementById
     */
    public void setIdAttributeNS(Element element, String namespaceURI, 
	String localName) {
	if (element == null) {
	    throw new NullPointerException("element is null");
	}
	if (localName == null) {
	    throw new NullPointerException("localName is null");
	}
	String idValue = element.getAttributeNS(namespaceURI, localName);
	if (idValue == null || idValue.length() == 0) {
	    throw new IllegalArgumentException(localName + " is not an " +
		"attribute");
	}
	idMap.put(idValue, element);
    }

    /**
     * Returns a read-only iterator over the set of Id/Element mappings of 
     * this <code>DOMCryptoContext</code>. Attempts to modify the set via the
     * {@link Iterator#remove} method throw an
     * <code>UnsupportedOperationException</code>. The mappings are returned
     * in no particular order. Each element in the iteration is represented as a
     * {@link java.util.Map.Entry}. If the <code>DOMCryptoContext</code> is 
     * modified while an iteration is in progress, the results of the 
     * iteration are undefined.
     *
     * @return a read-only iterator over the set of mappings
     */
    public Iterator iterator() {
	return Collections.unmodifiableMap(idMap).entrySet().iterator();
    }

    /**
     * This implementation uses an internal {@link HashMap} to get the object 
     * that the specified key maps to. 
     */
    public Object get(Object key) {
	return objMap.get(key);
    }

    /**
     * This implementation uses an internal {@link HashMap} to map the key
     * to the specified object.
     *
     * @throws IllegalArgumentException {@inheritDoc}
     */
    public Object put(Object key, Object value) {
	return objMap.put(key, value);
    }
}
