//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.10 at 07:27:30 PM CST 
//


package com.engine.parse.omnigraffle.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "arrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse"
})
@XmlRootElement(name = "array")
public class OmniGraffleArray {

    @XmlElements({
        @XmlElement(name = "array", type = OmniGraffleArray.class),
        @XmlElement(name = "data", type = OmniGraffleData.class),
        @XmlElement(name = "date", type = OmniGraffleDate.class),
        @XmlElement(name = "dict", type = OmniGraffleDict.class),
        @XmlElement(name = "real", type = OmniGraffleReal.class),
        @XmlElement(name = "integer", type = OmniGraffleInteger.class),
        @XmlElement(name = "string", type = String.class),
        @XmlElement(name = "true", type = OmniGraffleTrue.class),
        @XmlElement(name = "false", type = OmniGraffleFalse.class)
    })
    protected List<Object> arrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse;

    /**
     * Gets the value of the arrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OmniGraffleArray }
     * {@link OmniGraffleData }
     * {@link OmniGraffleDate }
     * {@link OmniGraffleDict }
     * {@link OmniGraffleReal }
     * {@link OmniGraffleInteger }
     * {@link String }
     * {@link OmniGraffleTrue }
     * {@link OmniGraffleFalse }
     * 
     * 
     */
    public List<Object> getArrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse() {
        if (arrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse == null) {
            arrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse = new ArrayList<Object>();
        }
        return this.arrayOrDataOrDateOrDictOrRealOrIntegerOrStringOrTrueOrFalse;
    }

}
