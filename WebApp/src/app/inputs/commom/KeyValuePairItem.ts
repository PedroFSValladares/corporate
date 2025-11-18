export class KeyValuePairItem<key, value> {
  key: key|null = null;
  value: value|null = null;

  constructor(key?: key|null, value?: value|null) {
    if(key != null)
      this.key = key;
    if (value != null)
      this.value = value;
  }
}
