<template>
  <v-card class="contents">
    <v-card-title>
      <div>
        <span>{{ list.title }}</span>
        <v-btn v-if="noItem" text @click="onDelete">×</v-btn>
      </div>
    </v-card-title>
    <v-container>
      <v-row v-for="todo in list.children" :key="todo.id">
        <v-col cols="12">
          <Todo v-bind="todo" :parentId="list.id" />
        </v-col>
      </v-row>
    </v-container>
    <v-card-actions class="btn">
      <Create :listId="list.listId" />
    </v-card-actions>
  </v-card>
</template>

<script>
import Todo from "./Todo";
import Create from "./Create";
import { postData, LIST_DELETE } from "../common/API";
import { MUTATION_KEYS } from "../store";

export default {
  name: "List",
  props: { list: Object },
  components: {
    Todo,
    Create,
  },
  computed: {
    noItem() {
      //子要素がない場合True
      return (
        Array.isArray(this.list.children) && this.list.children.length == 0
      );
    },
  },
  methods: {
    async onDelete() {
      // 削除処理
      const lists = await postData(LIST_DELETE, { listId: this.list.listId });
      this.$store.commit(MUTATION_KEYS.SET_LISTS, lists);
    },
  },
};
</script>

<style scoped>
.contents {
  margin: 8px;
  width: 300px;
}
.btn {
  direction: rtl;
}
</style>
