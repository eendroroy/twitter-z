package com.indrajit.tfz.helper;

import com.domingosuarez.boot.autoconfigure.jade4j.JadeHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author indrajit
 */

@JadeHelper("DH")
public class DateHelper {

  public String format(Date date) {
    if (date == null) {
      return "[Not Given]";
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    return sdf.format(date);
  }

}
