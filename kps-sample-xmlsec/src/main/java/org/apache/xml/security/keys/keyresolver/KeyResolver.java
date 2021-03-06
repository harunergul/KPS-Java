
/*
 * Copyright  1999-2010 The Apache Software Foundation.
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
package org.apache.xml.security.keys.keyresolver;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.crypto.SecretKey;

import org.apache.xml.security.keys.storage.StorageResolver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * KeyResolver is factory class for subclass of KeyResolverSpi that
 * represent child element of KeyInfo.
 *
 * @author $Author: coheigea $
 * @version %I%, %G%
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class KeyResolver {

   /** {@link org.apache.commons.logging} logging facility */
   static org.apache.commons.logging.Log log = 
      org.apache.commons.logging.LogFactory.getLog(KeyResolver.class.getName());

   /** Field _alreadyInitialized */
   static boolean _alreadyInitialized = false;

   /** Field _resolverVector */
   static List _resolverVector = null;

   /** Field _resolverSpi */
   protected KeyResolverSpi _resolverSpi = null;

   /** Field _storage */
   protected StorageResolver _storage = null;

   /**
    * Constructor ResourceResolver
    *
    * @param className
    * @throws ClassNotFoundException
    * @throws IllegalAccessException
    * @throws InstantiationException
    */
   private KeyResolver(String className)
           throws ClassNotFoundException, IllegalAccessException,
                  InstantiationException {
      this._resolverSpi =
         (KeyResolverSpi) Class.forName(className).newInstance();
      this._resolverSpi.setGlobalResolver(true);
   }

   /**
    * Method length
    *
    * @return the length of resolvers registered
    */
   public static int length() {
      return KeyResolver._resolverVector.size();
   }

   /**
    * This method is called when a KeyResolver is successful
    * with the hope that this information can improve performance.
    * @param hintI
    */
   public static void hit(Iterator hintI) {
	   // Move the successful KeyResolver to the beginning of the list
	   ResolverIterator hint = (ResolverIterator) hintI;
	   int i = hint.i;
	   if (i!=1 && hint.res ==_resolverVector) {
		   List resolverVector=(List)((ArrayList)_resolverVector).clone();        		   		 
  		Object ob=resolverVector.remove(i-1);
  		resolverVector.add(0,ob);
  		 _resolverVector=resolverVector; 
  	 } else {
  		 //System.out.println("KeyResolver hitting");
  	 }
   }

   /**
    * Method getX509Certificate
    *
    * @param element
    * @param BaseURI
    * @param storage
    * @return The certificate represented by the element.
    * 
    * @throws KeyResolverException
    */
   public static final X509Certificate getX509Certificate(
           Element element, String BaseURI, StorageResolver storage)
              throws KeyResolverException {

	  // use the old vector to not be hit by updates
	  List resolverVector = KeyResolver._resolverVector;
      for (int i = 0; i < resolverVector.size(); i++) {
		  KeyResolver resolver=
            (KeyResolver) resolverVector.get(i);

		  if (resolver==null) {
            Object exArgs[] = {
               (((element != null)
                 && (element.getNodeType() == Node.ELEMENT_NODE))
                ? element.getTagName()
                : "null") };

            throw new KeyResolverException("utils.resolver.noClass", exArgs);
         }
         if (log.isDebugEnabled())
         	log.debug("check resolvability by class " + resolver.getClass());

         X509Certificate cert=resolver.resolveX509Certificate(element, BaseURI, storage);
         if (cert!=null) {
            return cert;
         }
      }

      Object exArgs[] = {
         (((element != null) && (element.getNodeType() == Node.ELEMENT_NODE))
          ? element.getTagName()
          : "null") };

      throw new KeyResolverException("utils.resolver.noClass", exArgs);
   }
   
   /**
    * Method getPublicKey
    *
    * @param element
    * @param BaseURI
    * @param storage
    * @return the public key contained in the element
    * 
    * @throws KeyResolverException
    */
   public static final PublicKey getPublicKey(
           Element element, String BaseURI, StorageResolver storage)
              throws KeyResolverException {
	  
      // use the old vector to not be hit by updates
	  List resolverVector = KeyResolver._resolverVector;
      for (int i = 0; i < resolverVector.size(); i++) {
		  KeyResolver resolver=
            (KeyResolver) resolverVector.get(i);

		  if (resolver==null) {
            Object exArgs[] = {
               (((element != null)
                 && (element.getNodeType() == Node.ELEMENT_NODE))
                ? element.getTagName()
                : "null") };

            throw new KeyResolverException("utils.resolver.noClass", exArgs);
         }
         if (log.isDebugEnabled())
         	log.debug("check resolvability by class " + resolver.getClass());

         PublicKey cert=resolver.resolvePublicKey(element, BaseURI, storage);
         if (cert!=null) {
        	 if (i!=0 && resolverVector==_resolverVector) {
        		 //update resolver.        		 
        		 resolverVector=(List)((ArrayList)_resolverVector).clone();        		   		 
		  		 Object ob=resolverVector.remove(i);
		  		 resolverVector.add(0,ob);
   		 		 _resolverVector=resolverVector;
        	 } 
        	 return cert;
         }
      }

      Object exArgs[] = {
         (((element != null) && (element.getNodeType() == Node.ELEMENT_NODE))
          ? element.getTagName()
          : "null") };

      throw new KeyResolverException("utils.resolver.noClass", exArgs);
   }

   /**
    * The init() function is called by org.apache.xml.security.Init.init()
    */
   public static void init() {

      if (!KeyResolver._alreadyInitialized) {
         KeyResolver._resolverVector = new ArrayList(10);
         _alreadyInitialized = true;
      }
   }

   /**
    * This method is used for registering {@link KeyResolverSpi}s which are
    * available to <I>all</I> {@link org.apache.xml.security.keys.KeyInfo} objects. This means that
    * personalized {@link KeyResolverSpi}s should only be registered directly
    * to the {@link org.apache.xml.security.keys.KeyInfo} using 
    * {@link org.apache.xml.security.keys.KeyInfo#registerInternalKeyResolver}.
    *
    * @param className
    * @throws InstantiationException 
    * @throws IllegalAccessException 
    * @throws ClassNotFoundException 
    */
   public static void register(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      KeyResolver._resolverVector.add(new KeyResolver(className));
   }

   /**
    * This method is used for registering {@link KeyResolverSpi}s which are
    * available to <I>all</I> {@link org.apache.xml.security.keys.KeyInfo} objects. This means that
    * personalized {@link KeyResolverSpi}s should only be registered directly
    * to the {@link org.apache.xml.security.keys.KeyInfo} using {@link org.apache.xml.security.keys.KeyInfo#registerInternalKeyResolver}.
    *
    * @param className
    */
   public static void registerAtStart(String className) {
       // For backwards compatibility, use a RuntimeException instead of adding a throws clause
       KeyResolver resolver = null;
       Exception ex = null;
       
       try {
           resolver = new KeyResolver(className);
       } catch (ClassNotFoundException e) {
           ex = e;
       } catch (IllegalAccessException e) {
           ex = e;
       } catch (InstantiationException e) {
           ex = e;
       }
       
       if (ex != null) {
           throw (IllegalArgumentException) new
               IllegalArgumentException("Invalid KeyResolver class name").initCause(ex);
       }
       
       KeyResolver._resolverVector.add(0, resolver);
   }

   /**
    * Method resolvePublicKey
    *
    * @param element
    * @param BaseURI
    * @param storage 
    * @return resolved public key from the registered from the elements
    * 
    * @throws KeyResolverException
    */
   public PublicKey resolvePublicKey(
           Element element, String BaseURI, StorageResolver storage)
              throws KeyResolverException {
      return this._resolverSpi.engineLookupAndResolvePublicKey(element, BaseURI, storage);
   }

   /**
    * Method resolveX509Certificate
    *
    * @param element
    * @param BaseURI
    * @param storage
    * @return resolved X509certificate key from the registered from the elements
    * 
    * @throws KeyResolverException
    */
   public X509Certificate resolveX509Certificate(
           Element element, String BaseURI, StorageResolver storage)
              throws KeyResolverException {
      return this._resolverSpi.engineLookupResolveX509Certificate(element, BaseURI,
              storage);
   }

   /**
    * @param element
    * @param BaseURI
    * @param storage
    * @return resolved SecretKey key from the registered from the elements
    * @throws KeyResolverException
    */
   public SecretKey resolveSecretKey(
           Element element, String BaseURI, StorageResolver storage)
              throws KeyResolverException {
      return this._resolverSpi.engineLookupAndResolveSecretKey(element, BaseURI,
              storage);
   }

   /**
    * Method setProperty
    *
    * @param key
    * @param value
    */
   public void setProperty(String key, String value) {
      this._resolverSpi.engineSetProperty(key, value);
   }

   /**
    * Method getProperty
    *
    * @param key
    * @return the property setted for this resolver
    */
   public String getProperty(String key) {
      return this._resolverSpi.engineGetProperty(key);
   }


   /**
    * Method understandsProperty
    *
    * @param propertyToTest
    * @return true if the resolver understands property propertyToTest
    */
   public boolean understandsProperty(String propertyToTest) {
      return this._resolverSpi.understandsProperty(propertyToTest);
   }


   /**
    * Method resolverClassName
    *
    * @return the name of the resolver.
    */
   public String resolverClassName() {
      return this._resolverSpi.getClass().getName();
   }

   /**
    * Iterate over the KeyResolverSpi instances
    */
   static class ResolverIterator implements Iterator {
        List res;
        Iterator it;
        int i;

        public ResolverIterator(List list) {
            res = list;
            it = res.iterator();
        }

        public boolean hasNext() {
            return it.hasNext();
        }

        public Object next() {
            i++;
            KeyResolver resolver = (KeyResolver) it.next();
            if (resolver == null) {
                throw new RuntimeException("utils.resolver.noClass");
            }

            return resolver._resolverSpi;
        }

        public void remove() {
            throw new UnsupportedOperationException(
                    "Can't remove resolvers using the iterator");
        }
	};
	
	public static Iterator iterator() {
		return new ResolverIterator(_resolverVector);
   }
}
