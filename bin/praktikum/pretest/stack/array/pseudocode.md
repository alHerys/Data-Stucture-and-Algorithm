// Ini pseudocode untuk push()
PROCEDURE PUSH(item):
  IF count EQUALS MAX_SIZE THEN
    DISPLAY "Error: Stack penuh"
    RETURN
  END IF

  FOR i FROM count DOWNTO 1:
    array[i] = array[i-1]
  ENDFOR

  array[0] = item

  INCREMENT count
END PROCEDURE

// Ini pseudocode untuk pop()
PROCEDURE POP():
  IF count EQUALS 0 THEN
    DISPLAY "Error: Stack kosong"
  END IF

  topItem = array[0]

  DECREMENT count

  FOR i FROM 0 TO count-1:
    array[i] = array[i+1]
  ENDFOR

  RETURN topItem
END PROCEDURE