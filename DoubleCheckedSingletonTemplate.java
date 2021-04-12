#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

#if (${IMPORT_BLOCK} != "")${IMPORT_BLOCK}
#end
#parse("File Header.java")
#if (${VISIBILITY} == "PUBLIC")public #end class ${NAME} #if (${SUPERCLASS} != "")extends ${SUPERCLASS} #end #if (${INTERFACES} != "")implements ${INTERFACES} #end {
  private static volatile ${NAME} sInstance = null;

  private ${NAME}() {
    if (sInstance != null) {
      throw new AssertionError(
          "Another instance of "
              + ${NAME}.class.getName()
              + " class already exists, Can't create a new instance.");
    }
  }

   #if (${VISIBILITY} == "PUBLIC")public #end static ${NAME} getInstance() {
    if (sInstance == null) {
      synchronized (${NAME}.class) {
        if (sInstance == null) {
          sInstance = new ${NAME}();
        }
      }
    }
    return sInstance;
  }
}