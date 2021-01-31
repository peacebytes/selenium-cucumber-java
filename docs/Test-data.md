# How to deal with test data?

Test data is stored at `src\main\resources\TestData.json`. Test Data will be loaded in Hooks for each test scenario.

Usage in Step Definition:
- If test data is an array, call:
```
TestDataJSONReader.readJsonArray(keyValueInJson);
```
- If test data is an object, call:
```
TestDataJSONReader.readJsonObject(keyValueInJson);
```
