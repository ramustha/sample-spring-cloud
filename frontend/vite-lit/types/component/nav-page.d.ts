import { TwLitElement } from '../common/TwLitElement';
export declare class NavPage extends TwLitElement {
    profileActive: boolean;
    render(): import("lit-html").TemplateResult<1>;
    private onProfileClicked;
}
declare global {
    interface HTMLElementTagNameMap {
        'nav-page': NavPage;
    }
}
