
  function loadFiles(elem, files, completion) {
    var file = files.shift();
    console.log("LOAD FILE: ", file);
    if (files.length > 0) {
      $.get(file, function(data) {
        //console.log("================ File - ", file, data);
        elem.html( elem.html() + "\n\n" + data);
        loadFiles(elem, files);
      });
    } else {
      $.get(file, function(data) {
        //console.log("================ File - ", file, data);
        elem.html( elem.html() + "\n\n" + data);
        if (completion) {
          completion();
        }
      });
    }
  }


function process_lambdaman(source) {
    var lines = [];
    var prelines = source.split("\n")

    var returnLine = /^(RETURN)$/;
    var functionLine = /^(FUNCTION)/;
    

    for (var i = 0 ; i < prelines.length; i++) {
        var line = prelines[i];

        if (returnLine.test(line)) {
           lines.push("mov pc, h");
           continue
        }

        if (functionLine.test(line)) {
           var labelName = line.replace("FUNCTION", "");

           lines.push("mov h, pc");
           lines.push("add h, 3");
           lines.push("mov pc," + labelName);
           continue
        } 

        lines.push(line);  
    }

    var cleaned_up_lines = [];
    var labels = {};

    var commentline = /^\s*;/;
    var emptyline = /^\s*$/;
    var label_regexp = /^\w+:$/;

    var constants = {

      "CELL_WALL" : 0,
      "CELL_EMPTY" : 1,
      "CELL_PILL" : 2,
      "CELL_POWER_PILL" : 3,
      "CELL_FRUIT_LOCATION" : 4,
      "CELL_LAMDA_MAN_START" : 5,
      "CELL_GHOST_START" : 6,

      "VIT_STANDARD" : 0,
      "VIT_FRIGHT_MODE" : 1,
      "VIT_INVISIBLE" : 2,

      "DIRECTION_UP" : 0,
      "DIRECTION_RIGHT" : 1,
      "DIRECTION_DOWN" : 2,
      "DIRECTION_LEFT" : 3
    }

    var address = 0;

    //  Grab all labels
    for (var i = 0 ; i < lines.length; i++) {
        var line = lines[i];
        if (commentline.test(line)) {
            //cleaned_up_lines.push(line)
            continue
        }
        if (emptyline.test(line)) {
            cleaned_up_lines.push(line)
            continue
        }
        if (label_regexp.test(line)) {
           var label = line.substr(0, line.length - 1)
           labels[label] = address
           continue
        }
        cleaned_up_lines.push(line)
        address++
    }

    // Replace all labels
    address = 0
    for (var i = 0 ; i < cleaned_up_lines.length; i++) {
        var line = cleaned_up_lines[i];
         if (commentline.test(line)) {
            continue
        }
        if (emptyline.test(line)) {
            continue
        }
        for (var l in constants) {
            var line2 = line.replace(l, constants[l])
            if (line != line2) {
                console.log("Replaced " + line + "; -> " + line2)
                line2 += " ; " + l
            }
            cleaned_up_lines[i] = line2
            line = line2
        }
        
        for (var l in labels) {
            var line2 = line.replace(l, labels[l])
            if (line != line2) {
                console.log("Replaced " + line + "; -> " + line2)
                line2 += " ; " + l
            }
            if (labels[l] == address) {
               line2 = "; -- FUNC " + l + "\n" + line2
            }
            cleaned_up_lines[i] = line2
            line = line2
        }
        address++
    }

    console.log(cleaned_up_lines)
    console.log(labels)
    console.log(cleaned_up_lines.join("\n"))
    return cleaned_up_lines.join("\n")

  }

