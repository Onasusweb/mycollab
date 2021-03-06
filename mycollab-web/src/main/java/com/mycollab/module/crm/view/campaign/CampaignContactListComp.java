/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycollab.module.crm.view.campaign;

import com.mycollab.common.i18n.GenericI18Enum;
import com.mycollab.configuration.SiteConfiguration;
import com.mycollab.db.arguments.NumberSearchField;
import com.mycollab.db.arguments.SearchField;
import com.mycollab.module.crm.CrmLinkGenerator;
import com.mycollab.module.crm.CrmTypeConstants;
import com.mycollab.module.crm.domain.CampaignContact;
import com.mycollab.module.crm.domain.CampaignWithBLOBs;
import com.mycollab.module.crm.domain.SimpleContact;
import com.mycollab.module.crm.domain.criteria.ContactSearchCriteria;
import com.mycollab.module.crm.i18n.ContactI18nEnum;
import com.mycollab.module.crm.service.CampaignService;
import com.mycollab.module.crm.service.ContactService;
import com.mycollab.module.crm.ui.CrmAssetsManager;
import com.mycollab.module.crm.ui.components.RelatedListComp2;
import com.mycollab.security.RolePermissionCollections;
import com.mycollab.spring.AppContextUtil;
import com.mycollab.vaadin.AppContext;
import com.mycollab.vaadin.ui.ELabel;
import com.mycollab.vaadin.web.ui.ConfirmDialogExt;
import com.mycollab.vaadin.web.ui.OptionPopupContent;
import com.mycollab.vaadin.web.ui.SplitButton;
import com.mycollab.vaadin.web.ui.UIConstants;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import org.vaadin.dialogs.ConfirmDialog;
import org.vaadin.viritin.button.MButton;

/**
 * @author MyCollab Ltd.
 * @since 2.0
 */
public class CampaignContactListComp extends RelatedListComp2<ContactService, ContactSearchCriteria, SimpleContact> {
    private static final long serialVersionUID = 4515934156312167566L;

    private CampaignWithBLOBs campaign;

    public CampaignContactListComp() {
        super(AppContextUtil.getSpringBean(ContactService.class), 20);
        this.setBlockDisplayHandler(new CampaignContactBlockDisplay());
    }

    @Override
    protected Component generateTopControls() {
        VerticalLayout controlsBtnWrap = new VerticalLayout();
        controlsBtnWrap.setWidth("100%");

        if (AppContext.canWrite(RolePermissionCollections.CRM_CONTACT)) {
            final SplitButton controlsBtn = new SplitButton();
            controlsBtn.addStyleName(UIConstants.BUTTON_ACTION);
            controlsBtn.setCaption(AppContext.getMessage(ContactI18nEnum.NEW));
            controlsBtn.setIcon(FontAwesome.PLUS);
            controlsBtn.addClickListener(event -> fireNewRelatedItem(""));
            final Button selectBtn = new Button(AppContext.getMessage(GenericI18Enum.BUTTON_SELECT), clickEvent -> {
                final CampaignContactSelectionWindow contactsWindow = new CampaignContactSelectionWindow(CampaignContactListComp.this);
                final ContactSearchCriteria criteria = new ContactSearchCriteria();
                criteria.setSaccountid(new NumberSearchField(AppContext.getAccountId()));
                UI.getCurrent().addWindow(contactsWindow);
                contactsWindow.setSearchCriteria(criteria);
                controlsBtn.setPopupVisible(false);
            });
            selectBtn.setIcon(CrmAssetsManager.getAsset(CrmTypeConstants.CONTACT));
            OptionPopupContent buttonControlLayout = new OptionPopupContent();
            buttonControlLayout.addOption(selectBtn);
            controlsBtn.setContent(buttonControlLayout);

            controlsBtnWrap.addComponent(controlsBtn);
            controlsBtnWrap.setComponentAlignment(controlsBtn, Alignment.MIDDLE_RIGHT);
        }

        return controlsBtnWrap;
    }

    public void displayContacts(final CampaignWithBLOBs campaign) {
        this.campaign = campaign;
        loadContacts();
    }

    private void loadContacts() {
        final ContactSearchCriteria criteria = new ContactSearchCriteria();
        criteria.setSaccountid(new NumberSearchField(SearchField.AND, AppContext.getAccountId()));
        criteria.setCampaignId(new NumberSearchField(SearchField.AND, campaign.getId()));
        setSearchCriteria(criteria);
    }

    @Override
    public void refresh() {
        loadContacts();
    }

    public class CampaignContactBlockDisplay implements BlockDisplayHandler<SimpleContact> {

        @Override
        public Component generateBlock(final SimpleContact contact, int blockIndex) {
            CssLayout beanBlock = new CssLayout();
            beanBlock.addStyleName("bean-block");
            beanBlock.setWidth("350px");

            VerticalLayout blockContent = new VerticalLayout();
            HorizontalLayout blockTop = new HorizontalLayout();
            blockTop.setSpacing(true);
            CssLayout iconWrap = new CssLayout();
            iconWrap.setStyleName("icon-wrap");
            ELabel contactAvatar = ELabel.fontIcon(CrmAssetsManager.getAsset(CrmTypeConstants.CONTACT));
            iconWrap.addComponent(contactAvatar);
            blockTop.addComponent(iconWrap);

            VerticalLayout contactInfo = new VerticalLayout();
            contactInfo.setSpacing(true);

            MButton btnDelete = new MButton("", clickEvent -> {
                ConfirmDialogExt.show(UI.getCurrent(),
                        AppContext.getMessage(GenericI18Enum.DIALOG_DELETE_TITLE, AppContext.getSiteName()),
                        AppContext.getMessage(GenericI18Enum.DIALOG_DELETE_SINGLE_ITEM_MESSAGE),
                        AppContext.getMessage(GenericI18Enum.BUTTON_YES),
                        AppContext.getMessage(GenericI18Enum.BUTTON_NO),
                        confirmDialog -> {
                            if (confirmDialog.isConfirmed()) {
                                CampaignService campaignService = AppContextUtil.getSpringBean(CampaignService.class);
                                CampaignContact associateContact = new CampaignContact();
                                associateContact.setContactid(contact.getId());
                                associateContact.setCampaignid(campaign.getId());
                                campaignService.removeCampaignContactRelationship(associateContact,
                                        AppContext.getAccountId());
                                CampaignContactListComp.this.refresh();
                            }
                        });
            }).withIcon(FontAwesome.TRASH_O).withStyleName(UIConstants.BUTTON_ICON_ONLY);

            blockContent.addComponent(btnDelete);
            blockContent.setComponentAlignment(btnDelete, Alignment.TOP_RIGHT);

            Label contactName = new Label("Name: <a href='"
                    + SiteConfiguration.getSiteUrl(AppContext.getUser()
                    .getSubdomain())
                    + CrmLinkGenerator.generateCrmItemLink(
                    CrmTypeConstants.CONTACT, contact.getId()) + "'>"
                    + contact.getContactName() + "</a>", ContentMode.HTML);

            contactInfo.addComponent(contactName);

            Label contactTitle = new Label("Title: "
                    + (contact.getTitle() != null ? contact.getTitle() : ""));
            contactInfo.addComponent(contactTitle);

            Label contactEmail = new Label("Email: "
                    + (contact.getEmail() != null ? "<a href='mailto:"
                    + contact.getEmail() + "'>" + contact.getEmail()
                    + "</a>" : ""), ContentMode.HTML);
            contactInfo.addComponent(contactEmail);

            Label contactOfficePhone = new Label(
                    "Office Phone: "
                            + (contact.getOfficephone() != null ? contact
                            .getOfficephone() : ""));
            contactInfo.addComponent(contactOfficePhone);

            blockTop.addComponent(contactInfo);
            blockTop.setExpandRatio(contactInfo, 1.0f);
            blockTop.setWidth("100%");
            blockContent.addComponent(blockTop);

            blockContent.setWidth("100%");

            beanBlock.addComponent(blockContent);
            return beanBlock;
        }

    }
}
