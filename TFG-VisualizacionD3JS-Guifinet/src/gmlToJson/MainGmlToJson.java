package gmlToJson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.util.NamespaceStack;
import org.xml.sax.helpers.NamespaceSupport;

public class MainGmlToJson {

	public static void main(String[] args) {
		jsonPorZona generen=new jsonPorZona("nodes.xml", "links.xml", 312456);
		generen.generarJSON();
	}

}
