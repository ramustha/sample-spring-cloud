import { defineConfig } from 'vite';

// https://vitejs.dev/config/
export default defineConfig(({ command, mode }) => {
  return {
    build: {
      rollupOptions: {
        input: {
          app: './index.html', // default
        },
      },
    },
  };
});
